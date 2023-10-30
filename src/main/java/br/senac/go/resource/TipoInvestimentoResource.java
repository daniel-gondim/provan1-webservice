package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.TipoConta;
import br.senac.go.model.TipoInvestimento;
import br.senac.go.service.TipoInvestimentoService;
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
@RequestMapping(path = "/api/tipoinvestimento")
@Tag(name = "tipoInvestimento", description = "documentação do resource Tipo Investimento")
public class TipoInvestimentoResource implements IResource<TipoInvestimento, Integer> {

    @Autowired
    TipoInvestimentoService tipoInvestimentoService;

    @Override
    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Cria um tipo de investimento",
            description = "Método responsável para criar um tipo de investimento no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento create(@Valid @RequestBody TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.create");
        log.debug(String.format("Executado método TipoContaInvestimento.create | valores: %s", entity.toString()));
        return tipoInvestimentoService.create(entity);
    }

    @Override
    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Recupera um tipo de investimento",
            description = "Método responsável por recuperar um tipo de investimento no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento read(@Valid @RequestBody TipoInvestimento entity) throws Exception {
        log.info("Executado método TipoInvestimentoResource.read");
        log.debug(String.format("Executado método TipoContaInvestimento.read | valores: %s", entity.toString()));
        return tipoInvestimentoService.read(entity);
    }

    @Override
    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Recupera um tipo de investimento baseado em um identificador",
            description = "Método responsável por recuperar um tipo de investimento baseado no identificador no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento readById(@PathVariable Integer id) throws Exception {
        log.info("Executado método TipoInvestimentoResource.readById");
        log.debug(String.format("Executado método TipoContaInvestimento.readById | valores: %s", id));
        return tipoInvestimentoService.readById(id);
    }

    @Override
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza um tipo de investimento",
            description = "Método responsável por atualizar um tipo de investimento no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento update(@Valid @RequestBody TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.update");
        log.debug(String.format("Executado método TipoContaInvestimento.update | valores: %s", entity.toString()));
        return tipoInvestimentoService.update(entity);
    }

    @Override
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza parte de um tipo de investimento",
            description = "Método responsável por atualizar parte de um tipo de investimento no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento updatePart(@PathVariable Integer id, @Valid @RequestBody TipoInvestimento entity) throws Exception {
        log.info("Executado método TipoInvestimentoResource.updatePart");
        log.debug(String.format("Executado método TipoContaInvestimento.updatePart | valores: %d, %s", id, entity.toString()));
        return tipoInvestimentoService.updatePart(id, entity);
    }

    @Override
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza todos os dados de um tipo de investimento",
            description = "Método responsável por atualizar todos os dados de um tipo de investimento no sistema",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = TipoInvestimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public TipoInvestimento updateFull(@PathVariable Integer id, @Valid @RequestBody TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.updateFull");
        log.debug(String.format("Executado método TipoContaInvestimento.updateFull | valores: %d, %s", id, entity.toString()));
        return tipoInvestimentoService.updateFull(id, entity);
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete um tipo de investimento com base no objeto informado.",
            description = "Método responsável para deletar um tipo de investimento com base no objeto informado.",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void delete(@PathVariable Integer id) {
        log.info("Executado método TipoInvestimentoResource.delete");
        log.debug(String.format("Executado método TipoContaInvestimento.delete | valores: %d", id));
        tipoInvestimentoService.deleteById(id);
    }

    @Override
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Delete um tipo de investimento com base no objeto informado.",
            description = "Método responsável para deletar um tipo de investimento com base no objeto informado.",
            tags = {"tipoInvestimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(schema = @Schema(implementation = TipoConta.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void deleteByEntity(@Valid @RequestBody TipoInvestimento entity) {
        log.info("Executado método TipoInvestimentoResource.deleteByEntity");
        log.debug(String.format("Executado método TipoContaInvestimento.deleteByEntity | valores: %s", entity.toString()));
        tipoInvestimentoService.delete(entity);
    }
}
