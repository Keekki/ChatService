import { Link } from 'react-router-dom';

const NavigationBar = () => {
  return (
    <nav className="navigation-bar">
      <Link to="/">Etusivu</Link>
      <a href="http://localhost:8081/login">Kirjaudu</a>
    </nav>
  );
};

export default NavigationBar;
