import os
import PyPDF2
from sentence_transformers import SentenceTransformer, util

model = SentenceTransformer("all-MiniLM-L6-v2")

def load_all_pdfs():
    folder_path = "pdfs/"
    pdf_data = []

    for filename in os.listdir(folder_path):
        if filename.lower().endswith(".pdf"):
            full_path = os.path.join(folder_path, filename)
            try:
                with open(full_path, "rb") as f:
                    reader = PyPDF2.PdfReader(f)
                    text = ""
                    for page in reader.pages:
                        page_text = page.extract_text()
                        if page_text:
                            text += page_text + "\n"

                    sentences = [s.strip() for s in text.split(".") if s.strip()]
                    pdf_data.append((filename, sentences))

            except:
                print(f"Could not read {filename}")

    return pdf_data


def semantic_search(pdf_data, question):
    question_embedding = model.encode(question, convert_to_tensor=True)
    results = []

    for filename, sentences in pdf_data:
        for sentence in sentences:
            sent_emb = model.encode(sentence, convert_to_tensor=True)
            score = util.pytorch_cos_sim(question_embedding, sent_emb).item()
            results.append((score, filename, sentence))

    # sort by most relevant
    results.sort(reverse=True, key=lambda x: x[0])
    return results[:5]   # return top 5 answers


def main():
    while(True):
        # folder = input("Enter folder path with PDFs: ")
        question = input("Enter your question: ")

        print("\nLoading PDFs...")
        pdf_data = load_all_pdfs()

        print("Searching...\n")
        top_results = semantic_search(pdf_data, question)

        for score, filename, sentence in top_results:
            print(f"📄 File: {filename}")
            print(f"➡️  {sentence}")
            print(f"Score: {round(score, 3)}\n")
            
        again = input("Do you want to ask again? (y/n)")
        if again.lower() == 'y':
            continue
        else:
            break


if __name__ == "__main__":
    main()
