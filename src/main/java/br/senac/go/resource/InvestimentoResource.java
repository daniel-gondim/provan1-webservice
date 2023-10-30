package br.senac.go.resource;

import br.senac.go.interfaces.IResource;
import br.senac.go.model.Investimento;
import br.senac.go.service.InvestimentoService;
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
@RequestMapping(path = "/api/investimento")
@Tag(name = "investimento", description = "documentação do resource Investimento")
public class InvestimentoResource implements IResource<Investimento, Integer> {
    
    @Autowired
    InvestimentoService investimentoService;

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Cria um investimento",
            description = "Método responsável para criar um investimento no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @Override
    public Investimento create(@Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.create");
        log.debug(String.format("Executado método InvestimentoResource.create | valores: %s", entity.toString()));
        return investimentoService.create(entity);
    }

    @GetMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Recupera um investimento",
            description = "Método responsável por recuperar um investimento no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @Override
    public Investimento read(@Valid @RequestBody Investimento entity) throws Exception {
        log.info("Executado método InvestimentoResource.read");
        log.debug(String.format("Executado método InvestimentoResource.read | valores: %s", entity.toString()));
        return investimentoService.read(entity);
    }


    @Override
    @GetMapping (value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Recupera um investimento baseado em um identificador",
            description = "Método responsável por recuperar um investimento baseado em um identificador no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Investimento readById(@PathVariable Integer id) throws Exception {
        log.info("Executado método InvestimentoResource.readById");
        log.debug(String.format("Executado método InvestimentoResource.readById | valores: %s", id));
        return investimentoService.readById(id);
    }

    @Override
    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza um investimento",
            description = "Método responsável por atualizar um investimento no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Investimento update(@Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s", entity.toString()));
        return investimentoService.update(entity);
    }

    @Override
    @PatchMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza todos os dados de um investimento",
            description = "Método responsável por atualizar todos os dados de um investimento no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Investimento updateFull(@PathVariable Integer id, @Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.updateFull");
        log.debug(String.format("Executado método InvestimentoResource.updateFull | valores: %d, %s", id, entity.toString()));
        return investimentoService.updateFull(id, entity);
    }


    @Override
    @PutMapping(value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(
            summary = "Atualiza parte de um investimento",
            description = "Método responsável por atualizar parte de um investimento no sistema",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "304", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public Investimento updatePart(@PathVariable Integer id, @Valid @RequestBody Investimento entity) throws Exception {
        log.info("Executado método InvestimentoResource.updatePart");
        log.debug(String.format("Executado método InvestimentoResource.updatePart | valores: %d, %s", id, entity.toString()));
        return investimentoService.updatePart(id, entity);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deleta um investimento com base no identificador",
            description = "Método responsável por deletar um investimento no sistema com base no identificador",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void delete(@PathVariable Integer id) {
        log.info("Executado método InvestimentoResource.delete");
        log.debug(String.format("Executado método InvestimentoResource.delete | valores: %d", id));
        investimentoService.deleteById(id);
    }


    @Override
    @DeleteMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @Operation(
            summary = "Deleta um investimento com base no objeto informado",
            description = "Método responsável por deletar um investimento no sistema com base no objeto informado",
            tags = {"investimento"})
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = {@Content(schema = @Schema(implementation = Investimento.class), mediaType = MediaType.APPLICATION_JSON_VALUE)}),
            @ApiResponse(responseCode = "303", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    public void deleteByEntity(@Valid @RequestBody Investimento entity) {
        log.info("Executado método InvestimentoResource.update");
        log.debug(String.format("Executado método InvestimentoResource.update | valores: %s", entity.toString()));
    }

    
}
