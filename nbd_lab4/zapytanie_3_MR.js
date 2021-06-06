var mapper = function() {
	var job = this.job
	job = job.replace(" IV", "")
	job = job.replace(" III", "")
	job = job.replace(" II", "")
	job = job.replace(" I", "")
	emit(job, 1);
};

var reducer = function(key, value) {
	return (key, key)
};

printjson(db.people.mapReduce(mapper, reducer, { out: {inline: 1} }))