import React, { Component } from 'react';
import Survey from './components/Survey.js';
import ReactDOM from 'react-dom';
import logo from './logo.svg';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
          <h1 className="App-title">Questionnaire</h1>
        </header>

        <Survey/>

      </div>
    );
  }
}

export default App;
