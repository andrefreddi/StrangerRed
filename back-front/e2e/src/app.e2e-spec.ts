import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('Espaço de trabalho', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('deve exibir mensagem de boas-vindas', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Estamos no ar!');
  });

  afterEach(async () => {
    // Afirmar que não há erros emitidos pelo navegador
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
