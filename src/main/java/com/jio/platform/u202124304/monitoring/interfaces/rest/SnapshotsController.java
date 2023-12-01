package com.jio.platform.u202124304.monitoring.interfaces.rest;

import com.jio.platform.u202124304.monitoring.domain.model.queries.GetSnapshotByIdQuery;
import com.jio.platform.u202124304.monitoring.domain.services.SnapshotCommandService;
import com.jio.platform.u202124304.monitoring.domain.services.SnapshotQueryService;
import com.jio.platform.u202124304.monitoring.interfaces.rest.resources.CreateSnapshotResource;
import com.jio.platform.u202124304.monitoring.interfaces.rest.resources.SnapshotResource;
import com.jio.platform.u202124304.monitoring.interfaces.rest.transform.CreateSnapshotCommandFromResourceAssembler;
import com.jio.platform.u202124304.monitoring.interfaces.rest.transform.SnapshotResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/snapshots", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Snapshots", description = "Snapshots Management Endpoints")
public class SnapshotsController {
    /**
     *  <remarks>
     * Desarrollado por: Leonardo Paul Lopez Huarcaya.
     * </remarks>
     */

    /**
     * <summary>
     *     SnapshotQueryService
     * </summary>
     */
    public final SnapshotQueryService snapshotQueryService;
    public final SnapshotCommandService snapshotCommandService;

    public SnapshotsController(SnapshotQueryService snapshotQueryService, SnapshotCommandService snapshotCommandService) {
        this.snapshotQueryService = snapshotQueryService;
        this.snapshotCommandService = snapshotCommandService;
    }

    /**
     * Creates a new snapshot.
     *
     * @param createSnapshotResource the resource containing the data for the course to be created
     * @return the created course resource
     * @see CreateSnapshotResource
     * @see SnapshotResource
     */

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



    /**
     * Get Enrollment by Identifier.
     * @param snapshotId The enrollment id.
     * @return The enrollment resource.
     * @see SnapshotResource
     */
    @GetMapping("/{snapshotId}")
    public ResponseEntity<SnapshotResource> getSnapshotById(@PathVariable Long snapshotId) {
        var getSnapshotByIdQuery = new GetSnapshotByIdQuery(snapshotId);
        var snapshot = snapshotQueryService.getSnapshotById(getSnapshotByIdQuery);
        if (snapshot.isEmpty()) return ResponseEntity.badRequest().build();
        var courseResource = SnapshotResourceFromEntityAssembler.toResourceFromEntity(snapshot.get());
        return ResponseEntity.ok(courseResource);
    }
}
