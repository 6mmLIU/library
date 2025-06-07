import { api } from './api.js';
const { createApp } = Vue;

createApp({
  data() {
    return {
      books: [],
      copies: [],
      borrows: [],
      newBook: { title: '', author: '', category: '', location: '' },
      newCopy: { bookId: '', code: '', location: '' },
      newBorrow: { copyId: '', borrower: '' },
      returnId: ''
    };
  },
  methods: {
    loadBooks() {
      api.fetchBooks().then(r => { this.books = r.data; });
    },
    loadCopies() {
      api.fetchCopies().then(r => { this.copies = r.data; });
    },
    loadBorrows() {
      api.fetchBorrows().then(r => { this.borrows = r.data; });
    },
    addBook() {
      api.addBook(this.newBook).then(() => {
        this.newBook = { title: '', author: '', category: '', location: '' };
        this.loadBooks();
      });
    },
    addCopy() {
      api.addCopy(this.newCopy).then(() => {
        this.newCopy = { bookId: '', code: '', location: '' };
        this.loadCopies();
      });
    },
    borrow() {
      api.borrowBook(this.newBorrow).then(() => {
        this.newBorrow = { copyId: '', borrower: '' };
        this.loadBorrows();
      });
    },
    returnBook() {
      api.returnBook(this.returnId).then(() => {
        this.returnId = '';
        this.loadBorrows();
      });
    }
  },
  mounted() {
    this.loadBooks();
    this.loadCopies();
    this.loadBorrows();
  }
}).use(ElementPlus).mount('#app');
