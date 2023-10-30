package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Pessoa;
import br.senac.go.service.PessoaService;
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
@RestController //Fala que o controlador vai trabalhar com REST
@RequestMapping(path = "/api/pessoa")
@Tag(name = "pessoa", description = "documentação da classe pessoa")
public class PessoaResource implements IResource<Pessoa, Integer> {

    @Autowired
    PessoaService pessoaService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
    @Operation(
            summary = "Cria uma pessoa",
            description = "Método responsáveo por criar pessoa",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa create(@Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.create");
        log.debug(String.format("Executado método PessoaResource.create | valores: %s", entity.toString()));

        return pessoaService.create(entity);
    }

    @Override
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )

    @Operation(
            summary = "Recupera uma pessoa",
            description = "Método responsável para recuperar uma pessoa no sistema",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa read(@Valid @RequestBody Pessoa entity) throws Exception {
        log.info("Executado método PessoaResource.read");
        log.debug(String.format("Executado método PessoaResource.read | valores: %s", entity.toString()));

        return pessoaService.read((entity));
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Recupera uma pessoa baseado em um identificador",
            description = "Método responsável para recuperar uma pessoa no sistema baseado no identificador",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa readById(@PathVariable Integer id) throws Exception {
        log.info("Executado método PessoaResource.readById");
        log.debug(String.format("Executado método PessoaResource.readById | valores: %d", id));
        return pessoaService.readById(id);
    }

    @Override
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza uma pessoa",
            description = "Método responsável para atualizar uma pessoa.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa update(@Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.update");
        log.debug(String.format("Executado método PessoaResource.update | valores: %s", entity.toString()));

        return pessoaService.update(entity);
    }

    @Override
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza parte de uma pessoa",
            description = "Método responsável para atualizar parte de uma pessoa.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa updatePart(@PathVariable Integer id, @Valid @RequestBody Pessoa entity) throws Exception {
        log.info("Executado método PessoaResource.updatePart");
        log.debug(String.format("Executado método PessoaResource.updatePart | valores: %d, %s", id, entity.toString()));
        return pessoaService.updatePart(id, entity);
    }

    @Override
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Atualiza todos os dados de uma pessoa",
            description = "Método responsável para atualizar todos os dados de uma pessoa.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Pessoa updateFull(@PathVariable Integer id, @Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.updateFull");
        log.debug(String.format("Executado método PessoaResource.updateFull | valores: %d, %s", id, entity.toString()));
        return pessoaService.updateFull(id, entity);
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete uma pessoa com base no identificador.",
            description = "Método responsável para deletar uma pessoa com base no identificador",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void delete(@PathVariable Integer id) {
        log.info("Executado método PessoaResource.delete");
        log.debug(String.format("Executado método PessoaResource.delete | valores: %d", id));

        pessoaService.deleteById(id);
    }

    @Override
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Delete uma pessoa com base no objeto informado.",
            description = "Método responsável para deletar uma pessoa com base no objeto informado.",
            tags = {"pessoa"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = Pessoa.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void deleteByEntity(@Valid @RequestBody Pessoa entity) {
        log.info("Executado método PessoaResource.deleteByEntity");
        log.debug(String.format("Executado método PessoaResource.deleteByEntity | valores: %s", entity.toString()));

        pessoaService.delete(entity);

    }
}
