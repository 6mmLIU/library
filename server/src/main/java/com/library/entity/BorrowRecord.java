package com.library.entity;

import java.time.LocalDate;

/**
 * Borrowing history for a single copy.
 */
public class BorrowRecord {
    private Long id;
    /**
     * ID of the borrowed book copy.
     */
    private Long copyId;
    private String borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    // getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCopyId() {
        return copyId;
    }

    public void setCopyId(Long copyId) {
        this.copyId = copyId;
    }
    public String getBorrower() {
        return borrower;
    }
    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
    public LocalDate getBorrowDate() {
        return borrowDate;
    }
    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }
    public LocalDate getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
