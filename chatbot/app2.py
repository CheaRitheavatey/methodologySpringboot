import os
from langchain_community.document_loaders import PyPDFLoader
import langchain
# from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_huggingface import HuggingFaceEmbeddings
from langchain_chroma import Chroma
from langchain_community.llms import LlamaCpp
# from langchain.chains import RetrievalQA

PDF_FOLDER = "pdfs"
CHROMA_DIR = "chroma_db"
MODEL_PATH = "D:\Documents\GitHub\methodologySpringboot\chatbot\models\Llama-3-3B-Instruct-Q4_K_M.gguf" 

def load_pdfs(folder_path):
    docs = []
    for filename in os.listdir(folder_path):
        if filename.lower().endswith(".pdf"):
            path = os.path.join(folder_path, filename)
            loader = PyPDFLoader(path)
            # metadata will include source = path, so we know which PDF
            docs.extend(loader.load())
    return docs

def build_vectorstore(docs):
    splitter = langchain.RecursiveCharacterTextSplitter(
        chunk_size=1000,
        chunk_overlap=200
    )
    chunks = splitter.split_documents(docs)

    embeddings = HuggingFaceEmbeddings(
        model_name="sentence-transformers/all-MiniLM-L6-v2"
    )

    vectordb = Chroma.from_documents(
        documents=chunks,
        embedding=embeddings,
        persist_directory=CHROMA_DIR
    )
    return vectordb

def load_vectorstore():
    embeddings = HuggingFaceEmbeddings(
        model_name="sentence-transformers/all-MiniLM-L6-v2"
    )
    vectordb = Chroma(
        embedding_function=embeddings,
        persist_directory=CHROMA_DIR
    )
    return vectordb

def init_llm():
    llm = LlamaCpp(
        model_path=MODEL_PATH,
        n_ctx=4096,
        temperature=0.2,
        n_threads=8,      # adjust to your CPU
        n_gpu_layers=0    # set >0 if you have GPU support
    )
    return llm

def build_qa_chain(vectordb, llm):
    retriever = vectordb.as_retriever(search_kwargs={"k": 4})
    qa = langchain.RetrievalQA.from_chain_type(
        llm=llm,
        chain_type="stuff",
        retriever=retriever,
        return_source_documents=True,
    )
    return qa

def main():
    # Build or load Chroma index
    if not os.path.exists(CHROMA_DIR) or not os.listdir(CHROMA_DIR):
        print("No existing Chroma DB found. Ingesting PDFs...")
        docs = load_pdfs(PDF_FOLDER)
        vectordb = build_vectorstore(docs)
        print("Ingestion complete.")
    else:
        print("Loading existing Chroma DB...")
        vectordb = load_vectorstore()

    llm = init_llm()
    qa_chain = build_qa_chain(vectordb, llm)

    print("PDF LLM chat ready. Type 'exit' to quit.")
    while True:
        query = input("\nYou: ").strip()
        if query.lower() in ("exit", "quit", "q"):
            break

        result = qa_chain({"query": query})
        answer = result["result"]
        sources = result.get("source_documents", [])

        print("\nAssistant:", answer)
        if sources:
            print("\nSources:")
            for i, doc in enumerate(sources, start=1):
                print(f"- {i}. {doc.metadata.get('source')}")

if __name__ == "__main__":
    if not os.path.isdir(PDF_FOLDER):
        print(f"Folder '{PDF_FOLDER}' not found. Create it and put your PDFs inside.")
    else:
        main()
