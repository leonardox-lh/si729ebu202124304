package com.isa.platform.u202124304.monitoring.interfaces.rest;

import com.isa.platform.u202124304.monitoring.domain.model.commands.CreateSnapshotCommand;
import com.isa.platform.u202124304.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.isa.platform.u202124304.monitoring.domain.services.SnapshotCommandService;
import com.isa.platform.u202124304.monitoring.domain.services.SnapshotQueryService;
import com.isa.platform.u202124304.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.isa.platform.u202124304.monitoring.interfaces.rest.resources.SnapshotResource;
import com.isa.platform.u202124304.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.isa.platform.u202124304.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/{productId}/snapshots", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Snapshots", description = "Snapshots Management Endpoints")
public class SnapshotsController {

    public final SnapshotQueryService snapshotQueryService;
    public final SnapshotCommandService snapshotCommandService;

    public SnapshotsController(SnapshotQueryService snapshotQueryService, SnapshotCommandService snapshotCommandService) {
        this.snapshotQueryService = snapshotQueryService;
        this.snapshotCommandService = snapshotCommandService;
    }

    @PostMapping
    public ResponseEntity<SnapshotResource> createSnapshot(@RequestBody CreateSnapshotResource createSnapshotResource) {
        var createSnapshotCommand = CreateSnapshotCommandFromResourceAssembler.toCommandFromResource(createSnapshotResource);
        var snapshotId = snapshotCommandService.createSnapshot(createSnapshotCommand);
        if (snapshotId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.getSnapshotById(getSnapshotByIdQuery);
        if (snapshot.isEmpty()) return ResponseEntity.badRequest().build();
        var snapshotResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return new ResponseEntity<>(snapshotResource, HttpStatus.CREATED);
    }

    @GetMapping("/{snapshotId}")
    public ResponseEntity<SnapshotResource> getSnapshotById(@PathVariable Long snapshotId) {
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.getSnapshotById(getSnapshotByIdQuery);
        if (snapshot.isEmpty()) return ResponseEntity.badRequest().build();
        var courseResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return ResponseEntity.ok(courseResource);
    }
}
