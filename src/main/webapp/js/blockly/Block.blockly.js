window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Block = window.blockly.js.blockly.Block || {};

/**
 * @function Execute
 *
 * Block
 *
 *
 * @author Usuário de Teste
 * @since 7/16/2021, 11:14:23 AM
 *
 */
window.blockly.js.blockly.Block.ExecuteArgs = [];
window.blockly.js.blockly.Block.Execute = async function() {

  //
  console.log(await this.cronapi.server('blockly.ObterIP.getMyIPLocation').toPromise().run());
}
