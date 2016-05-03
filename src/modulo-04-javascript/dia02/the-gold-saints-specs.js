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

describe('Ex 4. Altura Media dos cavaleiros', function() {
  it('obterAlturaMedia (1.86)', function() {
    expect(obterAlturaMedia()).toEqual("1.86");
  });
});
