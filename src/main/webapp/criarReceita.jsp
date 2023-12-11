<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de receitas</title>
        
    </head>
    <body>
        <div><h1>Criamos esse sistema para você se organizar melhor com suas consultas</h1>
        </div>
        <div class = "container">
            <h2>Dados da receita</h2>
        </div>
        <div> <p>Por favor, preencha os dados da receita</p> </div>
        <section id="form-paciente" class="pady-3" >
        <form action="insert" method="POST" name="frmIndex"> 
            <div class="campos-form">
                <label for = "nome">Nome do paciente</label>
                <input type="text" name="nome" id="nome" >
            </div>
                <label for="nomemed">Medicamento</label>
                <input type ="text" name="nomemed" id ="nomemed">
            <div>
                <label for="descrcao">Pescrição</label>
                <input type="text" name="descricao" id ="descricao">
            </div>
            <button>Cadastrar</button> 
        </form>
        </section>
    </body>
</html>
