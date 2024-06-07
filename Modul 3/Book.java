class Book {
    private String id;
    private String title;
    private String author;
    private String category;
    private int loanDuration;
    private int stock;

    public Book(String id, String title, String author, String category, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    // Getters
    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public int getStock() { return stock; }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public int getLoanDuration() { return loanDuration; }
    public void setLoanDuration(int loanDuration) {
        this.loanDuration = loanDuration; }
}
