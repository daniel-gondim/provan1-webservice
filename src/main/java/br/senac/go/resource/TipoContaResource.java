package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Conta;
import br.senac.go.model.TipoConta;
import br.senac.go.service.TipoContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path = "/api/tipoconta")
@Tag(name = "tipoConta", description = "documentação do resource Tipo Conta")
public class TipoContaResource implements IResource<TipoConta, Integer> {

    @Autowired
    TipoContaService tipoContaService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Cria um tipo de conta",
            description = "Método responsável para criar um tipo de conta no sistema",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta create(@Valid @RequestBody TipoConta entity) {
        log.info("Executado método TipoContaResource.create");
        log.debug(String.format("Executado método TipoContaResource.create | valores: %s", entity.toString()));
        return tipoContaService.create(entity);
    }

    @Override
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Recupera um tipo de conta",
            description = "Método responsável para recuperar um tipo de conta no sistema",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta read(@Valid @RequestBody TipoConta entity) throws Exception {
        log.info("Executado método TipoContaResource.read");
        log.debug(String.format("Executado método TipoContaResource.read | valores: %s", entity.toString()));
        return tipoContaService.read(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Recupera um tipo de conta baseado em um identificador",
            description = "Método responsável para recuperar um tipo de conta no sistema baseado no identificador",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Conta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta readById(@PathVariable Integer id) throws Exception {
        log.info("Executado método TipoContaResource.readById");
        log.debug(String.format("Executado método TipoContaResource.readById | valores: %d", id));
        return tipoContaService.readById(id);
    }

    @Override
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza um tipo de conta",
            description = "Método responsável para atualizar um tipo de conta.",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta update(@Valid @RequestBody TipoConta entity) {
        log.info("Executado método TipoContaResource.update");
        log.debug(String.format("Executado método TipoContaResource.update | valores: %s", entity.toString()));
        return tipoContaService.update(entity);
    }

    @Override
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza parte de um tipo de conta",
            description = "Método responsável para atualizar parte de um tipo de conta.",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta updatePart(@PathVariable Integer id, @Valid @RequestBody TipoConta entity) throws Exception {
        log.info("Executado método TipoContaResource.updatePart");
        log.debug(String.format("Executado método TipoContaResource.updatePart | valores: %d, %s", id, entity.toString()));
        return tipoContaService.updatePart(id, entity);
    }

    @Override
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de um tipo de conta",
            description = "Método responsável por atualizar todos os dados de uma conta.",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoConta updateFull(@PathVariable Integer id, @Valid @RequestBody TipoConta entity) {
        log.info("Executado método TipoContaResource.updateFull");
        log.debug(String.format("Executado método TipoContaResource.updateFull | valores: %d, %s", id, entity.toString()));
        return tipoContaService.updateFull(id, entity);
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete um tipo de conta com base no identificador.",
            description = "Método responsável por deletar um tipo de conta com base no identificador.",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void delete(@PathVariable Integer id) {
        log.info("Executado método TipoContaResource.delete");
        log.debug(String.format("Executado método TipoContaResource.delete | valores: %d", id));
        tipoContaService.deleteById(id);

    }

    @Override
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Delete uma conta com base no objeto informado.",
            description = "Método responsável para deletar uma conta com base no objeto informado.",
            tags = {"tipoConta"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void deleteByEntity(@Valid @RequestBody TipoConta entity) {
        log.info("Executado método TipoContaResource.deleteByEntity");
        log.debug(String.format("Executado método TipoContaResource.deleteByEntity | valores: %s", entity.toString()));
        tipoContaService.delete(entity);
    }
}
