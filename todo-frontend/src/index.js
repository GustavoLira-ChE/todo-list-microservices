import React from "react";
import { createRoot } from 'react-dom/client';
import "bootstrap";
import "./styles/_custom.scss";
import App from './App';

const root = createRoot( document.getElementById('app')); 
root.render(<App />,);