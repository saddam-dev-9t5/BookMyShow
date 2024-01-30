package com.accio.bookmyshow.Repository;

import com.accio.bookmyshow.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
