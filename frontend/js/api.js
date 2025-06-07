export const api = {
  fetchBooks: () => axios.get('/books'),
  addBook: book => axios.post('/books', book),
  fetchCopies: () => axios.get('/copies'),
  addCopy: copy => axios.post('/copies', copy),
  fetchBorrows: () => axios.get('/borrows'),
  borrowBook: borrow => axios.post('/borrows', borrow),
  returnBook: id => axios.post(`/borrows/${id}/return`)
};
