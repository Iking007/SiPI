import { Link } from "react-router-dom";
import '../App.css';

export default function Header() {
  return (
    <div className="d-flex flex-column flex-md-row align-items-center pb-3 mb-4 border-bottom" id="head">
      <nav className="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <form className="d-flex" action="/books/query" method="get">
          <input type="text" autoComplete="off" name="filter" className="form-control my_input" placeholder="Книга" />
          <button type="submit" className="my_button">
            Поиск
          </button>
        </form>
        <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/">Главная</Link>
        <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/books">Книги</Link>
        <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/genres">Жанры</Link>
        <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/authors">Авторы</Link>
        {localStorage.token != null ? <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/favorites">Избранное</Link> : null}
        {localStorage.token == null ? <Link className="me-3 py-2 text-dark text-decoration-none my_link" to="/login">Вход</Link> :
          <Link class="me-3 py-2 text-dark text-decoration-none my_link" to="/prof">Профиль</Link>
        }
      </nav>
    </div>
  );
}
