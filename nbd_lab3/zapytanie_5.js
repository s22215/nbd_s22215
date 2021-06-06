printjson(db.people.aggregate([
	{$project:{"year": {$year: {$dateFromString: {dateString: "$birth_date"}}}, "first_name": "$first_name", "last_name": "$last_name", "city": "$location.city" }},
	{$match:{"year": {$gte:2000}}},
	{$project: {"_id":0, "year":0}}
]).toArray())