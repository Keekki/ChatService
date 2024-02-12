import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import './App.css';

const NavigationBar = () => {
  return (
    <nav className="navigation-bar">
      <Link to="/">Etusivu</Link>
      <Link to="/login">Kirjaudu</Link>
    </nav>
  );
};

const Home = () => <h2>Etusivu</h2>;
const Login = () => <h2>Kirjautumissivu</h2>;

const App = () => {
  return (
    <Router>
      <div className="App">
        <div className="navigation-container">
          <NavigationBar />
        </div>
        <div className="content-container">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
          </Routes>
        </div>
      </div>
    </Router>
  );
};

export default App;
