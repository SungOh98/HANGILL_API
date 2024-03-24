package com.koreatech.hangill.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Edge {
    @Id
    @GeneratedValue
    @Column(name = "edge_id")
    private Long id;

    // mm단위
    private Long distance;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "start_node_id")
    private Node startNode;

    @ManyToOne(fetch = LAZY, cascade = PERSIST)
    @JoinColumn(name = "end_node_id")
    private Node endNode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    // 객체 생성 메소드 추상화.
    public static Edge createEdge(Node startNode, Node endNode, Long distance) {
        Edge edge = new Edge();
        edge.startNode = startNode;
        edge.endNode = endNode;
        edge.distance = distance;
        return edge;
    }

    // 연관 관계 편의 메소드
    public void changeBuilding(Building building) {
        this.building = building;
    }
}
