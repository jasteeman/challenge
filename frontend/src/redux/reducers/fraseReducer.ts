import { createSlice, PayloadAction } from '@reduxjs/toolkit';
import { Frase } from '../../interfaces/IFrase';

interface FraseState {
  frases: Frase[];
  frasesFiltradas: Frase[];
}

const initialState: FraseState = {
  frases: [],
  frasesFiltradas: [],
};

const fraseReducer = (state = initialState, action) => {
  switch (action.type) {
    case 'AGREGAR_FRASE': 
      return {
        ...state,
        frases: [...state.frases, action.payload],
        frasesFiltradas: [...state.frases, action.payload],
      };
    case 'FILTRAR_FRASES':
      return {
        ...state,
        frasesFiltradas: state.frases.filter((frase) =>
          frase.texto.toLowerCase().includes(action.payload.toLowerCase())
        ),
      };
    case 'ELIMINAR_FRASE':
      return {
        ...state,
        frases: state.frases.filter((_, index) => index !== action.payload),
        frasesFiltradas: state.frases.filter((_, index) => index !== action.payload),
      };
    default:
      return state;
  }
};

export default fraseReducer;
