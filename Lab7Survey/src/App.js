import React, { Component } from 'react';
import Survey from './components/Survey.js';
import ReactDOM from 'react-dom';
import logo from './logo.svg';
import './App.css';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

class App extends Component {

  render() {

    return (

      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Survey</h1>
        </header>

        
       {/*Balise nécessaire pour utiliser Material-UI => s'applique au composant Survey */}
        <MuiThemeProvider> 

          <Survey/> 

        </MuiThemeProvider>

      </div>
    );
  }

}

export default App;
