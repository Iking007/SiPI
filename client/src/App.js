import { Route, BrowserRouter, Routes } from 'react-router-dom';
import './App.css';

import Header from './components/Header';
import Books from "./pages/Books";
import Book from "./pages/Book";
import Index from "./pages/Index";
import Query from "./pages/Query";
import Genres from "./pages/Genres";
import Login from "./pages/Login";
import AddBook from "./pages/AddBook";
import Authors from "./pages/Authors";
import Profile from "./pages/Profile";
import Favorites from "./pages/Favorites";
import Reg from "./pages/Reg";
import AddAuthor from "./pages/AddAuthor";
import AddGenre from "./pages/AddGenre";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Header />

        <Routes>
          <Route path="/" element={<Index />} />
          <Route path="/books" element={<Books />} />
          <Route path="/book/:id" element={<Book />} />
          <Route path="/books/query" element={<Query />} />
          <Route path="/genres" element={<Genres />} />
          <Route path="/authors" element={<Authors />} />
          <Route path="/reg" element={<Reg />} />
          <Route path="/login" element={<Login />} />
          <Route path="/prof" element={<Profile />} />
          <Route path="/favorites" element={<Favorites />} />
          <Route path="/add/book" element={<AddBook />} />
          <Route path="/add/author" element={<AddAuthor />} />
          <Route path="/add/genre" element={<AddGenre />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
