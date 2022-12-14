package com.api.equipamento.services;

@Service
public class EquipamentoService{
    @Autowired
    private Mensage mensage;

    @Autowired
    private Repository bicicleta;

    @Autowired
    private RepTranca tranca;


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
        

        bc.setMarca(bicicleta.getMarca());
        bc.setModelo(bicicleta.getModelo());
        bc.setAno(bicicleta.getAno());
        bc.setNumero(bicicleta.getNumero());
        bc.setStatus(bicicleta.getStatus());

        mensage.setMensage("Dados atualizados");
        return new ResponseEntity<>(bicicleta.save(bc), HttpStatus.CREATED);
    }

    public ResponseEntity<?> excluirBicicleta(int id){

        bicicleta.findById(id)? Bicicleta bc = bicicleta.findById(id):return bicicletaFindId(id);

        mensage.setMensage("Dados removidos");
        return new ResponseEntity<>(bicicleta.delete(bc), HttpStatus.DELETED);

    }

    ////////////////////  TRANCA  ////////////////////////////////

    public ResponseEntity<?> cadastrarTranca(Tranca trc){

        if(trc.getNumero.equals("")){
            mensage.setMensage("Dados Inválidos");
             return new ResponseEntity<>(mensage, HttpStatus.BAD_REQUEST);
        }

        mensage.setMensage("Dados cadastrados");
        return new ResponseEntity<>(tranca.save(bc), HttpStatus.CREATED);
    }

    public ResponseEntity<?> listarTrancas(){
        return new ResponseEntity<>(tranca.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> trancaFindId( int id){
        if(!tranca.findById(id)){
            mensage.setMensage("Tranca não encontrada");
            return new ResponseEntity<>(mensage, HttpStatus.NOT_FOUND);
        }

        mensage.setMensage("Tranca encontrada");
        return new ResponseEntity<>(tranca.findById(id), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<?> alterarTranca(int id){

        if(tranca.findById(id)){
            Tranca trc = tranca.findById(id);
        } else {
            return trancaFindId(id);
        }

        if(/*checar os dados*/){
            mensage.setMensage("Dados Inválidos");
            return new ResponseEntity<>(tranca.findById(id), HttpStatus.BAD_REQUEST);
        }
        

        trc.setNumero(tranca.getNumero());
        trc.setLocalizacao(tranca.getLocalizacao());
        trc.setAnoDeFabricacao(tranca.getAnoDeFrabricacao());
        trc.setModelo(tranca.getModelo());
        trc.setStatus(traca.getStatus());

        mensage.setMensage("Dados atualizados");
        return new ResponseEntity<>(tranca.save(trc), HttpStatus.CREATED);
    }

    public ResponseEntity<?> excluirTranca(int id){

        tranca.findById(id)? Tranca trc = tranca.findById(id):return trancaFindId(id);

        mensage.setMensage("Dados removidos");
        return new ResponseEntity<>(tranca.delete(trc), HttpStatus.DELETED);

    }
}