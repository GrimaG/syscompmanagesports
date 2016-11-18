Feature: Cadastro de Perfil
 In order to others people see a little more about me
 As a athlete
 I want to record my profile

  

 Scenario Outline: Cad Perfil
  Given the user is trying to create a new profile and is in the page cadastro
   When submit insert a complete name <name>
      And and email <email> never used before
      And a password <password>
      And gender <gender>
      And age <age>
      And sport <sport>
      And level <level>
      And school <school> 
      And city <city>
      And if user doesn't have school and want to create a new onw insert school name <sname>
      And school city <scity>
         
   Then return a  info <info> being sucessfull or not and showing error message
  Examples: 
  |  name   | email                    | password | gender   | age | sport  | level       | school | city       | sname | scity | info |
  | gustavo | guh.grimaldi@hotmail.com | 1234     | Masculino| 25  | corrida| iniciante   |        | são paulo  | abc | são paulo| usuario criado com sucesso!|
  | Fernanda| guh.grimaldi@hotmail.com | 1234     | Feminino | 25  | corrida| iniciante   |        | são paulo  | def | são paulo| email já está em uso     |
  | Augusto | augusto@hotmail.com      | 1234     | Masculino| 25  | corrida| iniciante   |        | são paulo  | abc | são paulo| Escola já está cadastrada|
  | gustavo | gustavo@hotmail.com      | 1234     | Masculino| 25  | corrida| iniciante   |   abc   | são paulo |     |          |usuario criado com sucesso!|


  
 Scenario Outline: Update Perfil
  Given the user login in your  profile <profile> 
     And password <password>
     And click on edit profile
    When change the name <name>
       And click on submit button
    Then redirect to a page if was aproved or not <page>

  
  |profile|password|name    | page      |
  |grimaG | 1234   |Xuxa    |index.html | 
  |grimaG | 1234   |Fernando|index.html |
  |grimaG | 1234   |Fernando|index.html |
