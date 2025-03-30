import fraseReducer from './fraseReducer';
import { AGREGAR_FRASE, FILTRAR_FRASES, ELIMINAR_FRASE } from '../actions/fraseActions';
import { Frase } from '../../interfaces/IFrase';

describe('Reducer de Frase', () => {
  it('debe retornar el estado inicial', () => {
    expect(fraseReducer(undefined, { type: '@@INIT' })).toEqual({
      frases: [],
      frasesFiltradas: [],
    });
  });

  it('debe manejar la acción AGREGAR_FRASE', () => {
    const frase: Frase = { id: 1, texto: 'Nueva frase' };
    const action = {
      type: AGREGAR_FRASE,
      payload: frase,
    };
    const expectedState = {
      frases: [frase],
      frasesFiltradas: [frase],
    };
    expect(fraseReducer(undefined, action)).toEqual(expectedState);
  });

  it('debe manejar la acción FILTRAR_FRASES', () => {
    const initialState = {
      frases: [
        { id: 1, texto: 'Frase uno' },
        { id: 2, texto: 'Frase dos' },
      ],
      frasesFiltradas: [
        { id: 1, texto: 'Frase uno' },
        { id: 2, texto: 'Frase dos' },
      ],
    };
    const action = {
      type: FILTRAR_FRASES,
      payload: 'uno',
    };
    const expectedState = {
      frases: [
        { id: 1, texto: 'Frase uno' },
        { id: 2, texto: 'Frase dos' },
      ],
      frasesFiltradas: [{ id: 1, texto: 'Frase uno' }],
    };
    expect(fraseReducer(initialState, action)).toEqual(expectedState);
  });

  it('debe manejar la acción ELIMINAR_FRASE', () => {
    const initialState = {
      frases: [
        { id: 1, texto: 'Frase uno' },
        { id: 2, texto: 'Frase dos' },
      ],
      frasesFiltradas: [
        { id: 1, texto: 'Frase uno' },
        { id: 2, texto: 'Frase dos' },
      ],
    };
    const action = {
      type: ELIMINAR_FRASE,
      payload: 0,
    };
    const expectedState = {
      frases: [{ id: 2, texto: 'Frase dos' }],
      frasesFiltradas: [{ id: 2, texto: 'Frase dos' }],
    };
    expect(fraseReducer(initialState, action)).toEqual(expectedState);
  });
});
