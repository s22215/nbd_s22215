printjson(db.people.aggregate([
	{$project:{"weight": {$toDouble: "$weight"}, "first_name": "$first_name", "last_name": "$last_name"}},
	{$match:{"weight": {$gte:68, $lt:71.5}}},
	{$project: {"_id":0}},
	{$project: {"first_name":1, "last_name": 1, "weight": 1}}
]).toArray())