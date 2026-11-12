
package com.igor.rpgapi.controller;

import com.igor.rpgapi.model.Item;
import com.igor.rpgapi.repository.ItemRepository;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemRepository repository;

    public ItemController(ItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Item> listarTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Item> cadastrar(@Valid @RequestBody Item item) {
        Item novoItem = repository.save(item);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody Item itemAtualizado) {

        return repository.findById(id)
                .map(item -> {
                    item.setNome(itemAtualizado.getNome());
                    item.setRaridade(itemAtualizado.getRaridade());
                    item.setPreco(itemAtualizado.getPreco());
                    item.setNivelMinimo(itemAtualizado.getNivelMinimo());

                    Item salvo = repository.save(item);

                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
