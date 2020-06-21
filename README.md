# ControladorAcessoApp
App para controlador de acesso de uma balada (PAIF) em Kotlin.

Este App utiliza as seguintes bibliotecas:
- Retrofit2 e Moshi - Para chamadas de API e tratamento de dados de retorno
- Zxing e Dexter - Para leitura de QRCode

Recursos adicionais
- Para finalidade do desenvolvimento, foi utilizado um retorno de API pelo Mocky.io
 
# Como funciona?
1) O app fara a leitura de um código.
2) O app jogará irá compor a informação deste código dentro de uma request para o Mocky.io e acionar um endpoint com este código
3) A Api retornará as informações para este endpoint correspondente.
4) Caso o status deste código seja "LIBERADO", a entrada desta pessoa é concedida. Caso o stauts seja "BLOQUEADO", o app dará um feedback visual ("NÃO AUTORIZADO").

## QRs para teste
![qr-correto](https://github.com/fabioiwano/ControladorAcessoApp/blob/master/app/src/main/res/drawable/qrcode.png)
![qr-errado](https://github.com/fabioiwano/ControladorAcessoApp/blob/master/app/src/main/res/drawable/qrcode_block.png)

## Teste simulador
![demovirtualizada](https://github.com/fabioiwano/ContoladorAcessoApp/blob/master/app/src/main/res/drawable/demo_virtualizada.gif)

## Teste com hardware
![demo-hardware](https://github.com/fabioiwano/ContoladorAcessoApp/blob/master/app/src/main/res/drawable/demo_hardware.gif)

