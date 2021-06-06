printjson(db.people.aggregate([
	{ $unwind : "$credit" },
		{$project:{
		"nationality": "$nationality",
		"bmi": {$divide: [ 
			{$toDouble: "$weight"}, 
			{ $multiply: [
				{$divide: [{$toDouble: "$height"}, 100]},
				{$divide: [{$toDouble: "$height"}, 100]}]} 
		]}}},
	{$group: {
		_id: "$nationality",
		bmi_avg: {$avg: "$bmi"},
		bmi_min: {$min: "$bmi"},
		bmi_max: {$max: "$bmi"}
	}}
]).toArray())