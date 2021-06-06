printjson(db.people.aggregate([
	{$project: {
    	uniq_job: { $substr: [ "$job", 0, { $indexOfBytes: [ "$job", " I" ] } ] }
     }},
	{$project: {
		_id: 0
	}}
]).toArray())