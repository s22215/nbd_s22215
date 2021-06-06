printjson(db.people.aggregate([
	{$project:{
		"sex": "$sex",
		"weight": {$toDouble: "$weight"}, 
		"height": {$toDouble: "$height"}}},
	{$group: {
		_id: "$sex",
		average_height: {$avg: "$height"},
		average_weight: {$avg: "$weight"},
	}}
]).toArray())