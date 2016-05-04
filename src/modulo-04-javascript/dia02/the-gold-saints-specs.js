'use strict';

describe('Ex 1. Doadores de sangue', function() {
  it('obterDoadores retorna todos com sangue O (4,8,11)', function() {
    expect(obterDoadores()).toEqual([goldSaints[4],goldSaints[8],goldSaints[11]]);
  });
});

describe('Ex 2. O com mais golpes', function() {
  it('obterCavaleiroComMaisGolpes retorna o com mais golpes (5,shaka)', function() {
    expect(obterCavaleiroComMaisGolpes()).toEqual(goldSaints[5]);
  });
});

describe('Ex 3. Obter meses com mais aniversarios', function() {
  it('obterMesesComMaisAniversarios()', function() {
    expect(obterMesesComMaisAniversarios()).toEqual(['Março','Maio','Novembro']);
  });
});

describe('Ex 4. Altura Media dos cavaleiros', function() {
  it('obterAlturaMedia (1.86)', function() {
    expect(obterAlturaMedia()).toEqual(1.85);
  });
});

describe('Ex 5. Altura Mediana dos cavaleiros', function() {
  it('obterAlturaMediana (1.84)', function() {
    expect(obterAlturaMediana()).toEqual(1.84);
  });
});

describe('Ex 6.A Peso Medio dos cavaleiros', function() {
  it('obterPesoMedio(84.27)', function() {
    expect(obterPesoMedio()).toEqual(84.27);
  });
});

describe('Ex 6.B Peso Medio dos cavaleiros', function() {
  it('obterPesoMedioDoadores(80.67)', function() {
    expect(obterPesoMedioDoadores()).toEqual(80.67);
  });
});
