import os
import PyPDF2

def load_all_pdfs():
    folder_path = "pdfs/"
    """Load text from all PDFs inside a folder."""
    pdf_texts = {}

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

                    pdf_texts[filename] = text
            except:
                print(f"Could not read {filename}")

    return pdf_texts


def answer_question(pdf_texts, query):
    """Search all PDFs and return file + matching sentences."""
    results = []

    for filename, text in pdf_texts.items():
        sentences = text.split(".")
        for s in sentences:
            if query.lower() in s.lower():
                results.append((filename, s.strip()))

    return results


def main():
    # folder = input("Enter folder path containing your PDFs: ")
    query = input("Enter your question or keyword: ")

    print("\nLoading PDFs...")
    pdf_texts = load_all_pdfs()

    print("Searching...\n")
    matches = answer_question(pdf_texts, query)

    if matches:
        print(f"🔎 Found {len(matches)} results:\n")
        for filename, sentence in matches:
            print(f"📄 File: {filename}")
            print(f"➡️  {sentence}")
            print()
    else:
        print("❌ No matches found.")


if __name__ == "__main__":
    main()
