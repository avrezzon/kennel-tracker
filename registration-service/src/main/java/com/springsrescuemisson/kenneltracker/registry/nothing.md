//			Client client;
//
//			Optional<Client> potentialClient = clients.findById(Integer.valueOf(id));
//
//			if(potentialClient.isEmpty()) {
//				client = new Client();
//				client.setId(Integer.valueOf(id));
//				mapper.updateClientFromDto(dto, client);
//				client = clients.save(client);
//				return new ResponseEntity<>(client, HttpStatus.CREATED);
//			}else {
//				client = potentialClient.get();
//				mapper.updateClientFromDto(dto, client);
//				try {
//					ValidationService.validate(client);
//					clients.save(client);
//					return new ResponseEntity<>(client, HttpStatus.OK);
//				} catch (ValidationException e) {
//					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//				}
//
//			}