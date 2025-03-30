import { configureStore } from '@reduxjs/toolkit';
import fraseReducer from './reducers/fraseReducer';

const store = configureStore({
  reducer: {
    frases: fraseReducer,
  },
});

export default store;
