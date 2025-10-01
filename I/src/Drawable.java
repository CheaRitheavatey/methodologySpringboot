public interface Drawable {
    void draw();
    default String getColor() {
        return "Black";
    }

    // nest interface
    interface Resizable {
        int MAX_RESIZE_PERCENTAGE = 500;
        void resize();
    }
}

