printjson(db.people.find(
	{"sex": "Male", "nationality": "Germany"},
	{_id:0, "first_name": 1, "last_name":1}
).toArray())