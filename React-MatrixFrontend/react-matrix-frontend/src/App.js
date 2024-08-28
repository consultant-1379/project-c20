import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";

import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import Homepage from "./Homepage";
import MatrixReview from "./MatrixReview";
import QuestionForm from "./QuestionForm";



function App() {
  return (
    <div className="App">
      <BrowserRouter>
          <Routes>
            <Route path="/" element={<Homepage />} />
            <Route path="/questionform" element={<QuestionForm />} />
            <Route path="/matrixreview" element={<MatrixReview />} />
          </Routes>
        </BrowserRouter>
    </div>

  );
}

export default App;
