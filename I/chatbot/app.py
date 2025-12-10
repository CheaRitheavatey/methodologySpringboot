import os
import pdfplumber

PDF_FOLDER = "pdfs"
CHUNK_SIZE = 1000

     

def load_pdfs(folder_path):
    index = []  # each item: {"pdf": name, "text": chunk_text}

    for filename in os.listdir(folder_path):
        if not filename.lower().endswith(".pdf"):
            continue

        pdf_path = os.path.join(folder_path, filename)
        print(f"Loading {pdf_path} ...")

        full_text = ""
        with pdfplumber.open(pdf_path) as pdf:
            for page in pdf.pages:
                page_text = page.extract_text() or ""
                full_text += page_text + "\n"

        # simple chunking by character length
        start = 0
        while start < len(full_text):
            end = start + CHUNK_SIZE
            chunk_text = full_text[start:end]
            if chunk_text.strip():
                index.append({
                    "pdf": filename,
                    "text": chunk_text
                })
            start = end

    print(f"Indexed {len(index)} chunks from PDFs.")
    return index


def score_chunk(chunk_text, query_words):
    text = chunk_text.lower()
    score = 0
    for w in query_words:
        if w and w in text:
            score += 1
    return score


def search(index, query):
    query_words = [w.strip().lower() for w in query.split() if len(w.strip()) > 2]
    if not query_words:
        return []

    scored = []
    for item in index:
        s = score_chunk(item["text"], query_words)
        if s > 0:
            scored.append((s, item))

    # sort best matches first, but return all
    scored.sort(key=lambda x: x[0], reverse=True)
    return [item for _, item in scored]


def chat_loop(index):
    print("PDF Chat (keyword search). Type 'exit' to quit.")
    while True:
        query = input("\nYou: ").strip()
        if query.lower() in ("exit", "quit", "q"):
            print("Goodbye.")
            break

        results = search(index, query)
        if not results:
            print("No matches found.")
            continue

        for i, res in enumerate(results, start=1):
            print(f"\nResult {i}:")
            print(f"PDF: {res['pdf']}")
            # show a shorter snippet
            snippet = res["text"].replace("\n", " ")
            if len(snippet) > 400:
                snippet = snippet[:400] + "..."
            print(f"Snippet: {snippet}")


if __name__ == "__main__":
    if not os.path.isdir(PDF_FOLDER):
        print(f"Folder '{PDF_FOLDER}' not found. Create it and put your PDFs inside.")
    else:
        index = load_pdfs(PDF_FOLDER)
        chat_loop(index)
