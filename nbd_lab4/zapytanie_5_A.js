printjson(db.people.aggregate([
	{ $unwind : "$credit" },
	{$project:{
		"sex": "$sex",
		"nationality": "$nationality",
		"balance": {$toDouble: "$credit.balance"},
		"currency": "$credit.currency"
	}},
	{$match:{
		nationality: "Poland",
		sex: "Female"
	}},
	{$group: {
		_id: "$currency",
		currency_sum: {$sum: "$balance"},
		currency_avg: {$avg: "$balance"}
	}}
]).toArray())