package za.ac.cput.repository;

import za.ac.cput.domian.Groundskeeper;

import java.util.List;

public interface IGroundskeeperRepository extends IRepository<Groundskeeper, String> {
    List<Groundskeeper> getAll();
}
