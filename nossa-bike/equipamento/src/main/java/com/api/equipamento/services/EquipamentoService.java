package com.api.equipamento.services;

@Service
public class EquipamentoService{
    @Autowired
    private Mensage mensage;

    @Autowired
    private Repository bicicleta;


    public ResponseEntity<?> cadastrar(Bicicleta bc){

        if(bc.getNumero.equals("")){
            mensage.setMensage("Dados Inválidos");
             return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        }


        mensage.setMensage("Dados cadastrados");
        return new ResponseEntity<>(bicicleta.save(bc), HttpStatus.CREATED);
    }

    public ResponseEntity<?> listarBicicletas(){
        return new ResponseEntity<>(bicicleta.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> bicicletaFindId( int id){
        if(!bicicleta.findById(id)){
            mensage.setMensage("Bicicleta não encontrada");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        }

        mensage.setMensage("Bicicleta encontrada");
        return new ResponseEntity<>(bicicleta.findById(id), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<?> alterarBicicleta(int id){

        if(bicicleta.findById(id)){
            Bicicleta bc = bicicleta.findById(id);
        } else {
            return bicicletaFindId(id);
        }

        if(/*checar os dados*/){
            mensage.setMensage("Dados Inválidos");
            return new ResponseEntity<>(bicicleta.findById(id), HttpStatus.BAD_REQUEST);
        }
        

        bc.setMarca(bike.getMarca());
        bc.setModelo(bike.getModelo());
        bc.setAno(bike.getAno());
        bc.setNumero(bike.getNumero());
        bc.setStatus(bike.getStatus());

        mensage.setMensage("Dados atualizados");
        return new ResponseEntity<>(bicicleta.save(bc), HttpStatus.CREATED);
    }

    public ResponseEntity<?> excluirBicicleta(int id){

        bicicleta.findById(id)? Bicicleta bc = bicicleta.findById(id):return bicicletaFindId(id);

        mensage.setMensage("Dados removidos");
        return new ResponseEntity<>(bicicleta.delete(bc), HttpStatus.DELETED);

    }
}