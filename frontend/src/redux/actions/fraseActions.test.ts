import { Frase } from '../../interfaces/IFrase';
import * as actions from './fraseActions'; 

describe('Acciones de Frase', () => {
  it('debe crear una acción para agregar una frase', () => {
    const frase: Frase = { id: 1, texto: 'Nueva frase' };
    const expectedAction = {
      type: actions.AGREGAR_FRASE,
      payload: frase,
    };
    expect(actions.agregarFrase(frase)).toEqual(expectedAction);
  });

  it('debe crear una acción para filtrar frases', () => {
    const texto = 'buscar';
    const expectedAction = {
      type: actions.FILTRAR_FRASES,
      payload: texto,
    };
    expect(actions.filtrarFrases(texto)).toEqual(expectedAction);
  });

  it('debe crear una acción para eliminar una frase', () => {
    const id = 1;
    const expectedAction = {
      type: actions.ELIMINAR_FRASE,
      payload: id,
    };
    expect(actions.eliminarFrase(id)).toEqual(expectedAction);
  });
});
