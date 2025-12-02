import torch
from langchain.document_loaders import PyPDFLoader
from langchain.embeddings import HuggingFaceEmbeddings
from langchain.vectorstores import Chroma
from langchain.llms import LlamaCpp
from langchain.memory import ConversationBufferMemory
from langchain.chains import ConversationalRetrievalChain

device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
loader = PyPDFLoader(file_path="pdfs/week1")

data = loader.load()
text_spliter = RecursiveCharacterTextSplitter(chunk_size=10000, chunk_overlap=200)
text_chuncks = text_spliter.split_documents(data)

# initalize large language model
llm_naswer_gen = LlamaCpp(
    streaming=True, 
    model_path="./mistral-7b-openorca.Q4_0.gguf", 
    temperature =0.75, top_p=1, f16_kv=True,
    verbose=False,
    n_ctx=4096
    )


# embedding
embedding = HuggingFaceEmbeddings(model_name=)