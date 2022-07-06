<?php 
    $client = new SoapClient('http://172.20.10.13:8788/GestionEtudiant?wsdl');
?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Liste des étudiants</title>
        <link rel="stylesheet" href="style.css">

        <style type="text/css">
          
        </style>
    </head>


    <body>
    <form class="form" method = "post">

         <div id="container">
            
            <form  method="POST">
                <h3>Ajouter étudiants</h3>
                
                <label><b>Nom</b></label>
                <input type="text" name="nom" required><br/>

                <label><b>Prénom</b></label>
                <input type="text" name="prenom" required><br/>

                <label><b>Login</b></label>
                <input type="text" name="login" required><br/>

                <label><b>Mot de passe</b></label>
                <input type="text" name="password" required>

                <input type="submit" id='submit' name="Ajouter" value='Ajouter' >
                
            </form>
        </div>

      
        
        <?php
            if (isset($_POST['nom'], $_POST['prenom'], $_POST['login'], $_POST['password']))
            {
                $parametres = array(
                    'nom' => $_POST['nom'],
                    'prenom' => $_POST['prenom'],
                    'login' => $_POST['login'],
                    'password' => $_POST['password']
                );

                $client->__soapCall('ajouter', array($parametres));

            }
        ?>
          
        <h1>Liste des étudiants</h1>
        <?php
            $etudiants = $client->__soapCall('lister', array());

            if (!empty($etudiants->return))
            {?>
                <table class="styled-table">    
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>login</th>
                        <th>password</th>
                    </tr><?php
                    if (!is_array($etudiants->return))
                    {?>
                        <tr>
                            <td><?= $etudiants->return->nom ?></td>
                            <td><?= $etudiants->return->prenom ?></td>
                            <td><?= $etudiants->return->login ?></td>
                            <td><?= $etudiants->return->password ?></td>
            </tr><?php
            }
            else
            {
                foreach ($etudiants->return as $etudiant)
                {?>
                    <tr>
                        <td><?= $etudiant->nom ?></td>
                        <td><?= $etudiant->prenom ?></td>
                        <td><?= $etudiant->login ?></td>
                        <td><?= $etudiant->password ?></td>
                    </tr><?php
                }
            }?>
        <table><?php
    }
    else
    {
        echo '<p>la liste des étudiants est vide</p>';
    }
  ?>


</body>
</html>
