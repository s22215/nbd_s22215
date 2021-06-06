import riak

DOC_NAME = "twelfth"

def get_bucket():
	client = riak.RiakClient(pb_port=8087)
	return client.bucket('s22215')

if __name__ == "__main__":
	print("Runnnig main()")
	
	bucket = get_bucket()
	
	# Add JSON document to bucket.
	document = {"is_alive": True, "number": 12, "first_name": "Peter", "last_name": "Capaldi"}
	key = bucket.new(DOC_NAME, data=document)
	key.store()
	print("Saved document: {}".format(document))

	# Download document and print its content 1.
	readValue = bucket.get(DOC_NAME)
	print("Downloaded document: {}".format(readValue.data))
	
	# Modify document value.
	readValue.data['is_alive'] = False
	print("Updated document before sending: {}".format(readValue.data))
	readValue.store()
	
	# Download document and print its content 2.
	readValue2 = bucket.get(DOC_NAME)
	print("Document downloaded after update: {}".format(readValue2.data))
	
	# Remove document.
	readValue2.delete()
	
	# Try do download document after it was deleted.
	readValue3 = bucket.get(DOC_NAME)
	print("Document downloaded after deletion: {}".format(readValue3.data))
	
	print("main() end.")
	