printjson(db.people.insert(
{
      "sex":"Male",
      "first_name":"Michal",
      "last_name":"Pilichowski",
      "job":"System Integration Analyst",
      "email":"mp@gmail.com",
      "location":{
         "city":"Warszawa",
         "address":{
            "streetname":"Warszawska",
            "streetnumber":"15"
         }
      },
      "description":"Had we but world enough and time...",
      "height":"111.11",
      "weight":"67.11",
      "birth_date":"1996-05-15T02:55:03Z",
      "nationality":"Poland",
      "credit":[
         {
            "type":"switch",
            "number":"1119888939100098222",
            "currency":"PLN",
            "balance":"1121.06"
         }
      ]
   }	
))