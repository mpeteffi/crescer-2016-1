<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario</h1>
            <form id="form" action="/pessoa" method="POST">
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">Nome: </span>
                    <input name="txtNome" id="txtNome" type="text" class="form-control" placeholder="Digite o nome" aria-describedby="basic-addon1">
                </div><br>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">Idade: </span>
                    <input name="txtIdade" id="txtIdade" type="number" class="form-control" placeholder="Digite a idade" aria-describedby="basic-addon2">
                </div>
                <div class="radio">
                  <label>
                    <input type="radio" name="txtSexo" id="optionsRadios1" value="Masculino" checked>
                    Masculino
                  </label>
                </div>
                <div class="radio">
                  <label>
                    <input type="radio" name="txtSexo" id="optionsRadios2" value="Feminino">
                    Feminino
                  </label>
                </div>
                <button class="btn btn-success" type="submit">Enviar</button>
            </form>
            <br>
            <ul class="list-group"></ul>
            </div>
            
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="script.js"></script>
    </body>
</html>
