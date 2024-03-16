import { Link } from 'react-router-dom';

const NavigationBar = () => {
  return (
    <nav className="navigation-bar">
      <Link to="/">Etusivu</Link>
      <Link to="/login">Kirjaudu</Link>
    </nav>
  );
};

export default NavigationBar;
